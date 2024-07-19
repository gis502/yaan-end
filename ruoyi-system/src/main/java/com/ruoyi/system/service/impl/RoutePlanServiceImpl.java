package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.config.Profile;
import com.graphhopper.util.*;
import com.ruoyi.system.domain.routeplan.Params;
import com.ruoyi.system.service.RoutePlanService;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.graphhopper.json.Statement.If;
import static com.graphhopper.json.Statement.Op.LIMIT;

@Service
public class RoutePlanServiceImpl implements RoutePlanService {
    @Override
    public JSONObject getWay(Params params) {

        GraphHopper hopper = new GraphHopper();
        // OSM 文件路径
        // hopper.setOSMFile("E:\\osm\\map.osm");
        hopper.setOSMFile("ruoyi-system/src/main/resources/osm/YaanRoadGeoJson.osm");
        // 读取完OSM数据之后会构建路线图，此处配置图的存储路径
        hopper.setGraphHopperLocation("ruoyi-system/src/main/resources/osm/resources");
        // add all encoded values that are used in the custom model, these are also available as path details or for client-side custom models
        // hopper.setEncodedValuesString("car_access, car_average_speed");

        CustomModel initModel = new CustomModel();
        initModel.addToSpeed(If("true", LIMIT, "60"));
        // initModel.addToPriority(If("!car_access", MULTIPLY, "0"));
        initModel.setDistanceInfluence(90d);

        // 支持car、bike、foot三种交通方式的导航
        // hopper.setProfiles(new Profile("car").setCustomModel(GHUtility.loadCustomModelFromJar("car.json")));
        hopper.setProfiles(new Profile("car").setCustomModel(initModel));
        // 设置汽车CH模式
        // hopper.getCHPreparationHandler().setCHProfiles(new CHProfile("car"));
        // 加载地图数据
        hopper.importOrLoad();

        double distance = 0;
        long timeInMs = 0;
        JSONArray pathWay = new JSONArray();
        double[] p = params.getPathWay()[0];
        double[] p2 = params.getPathWay()[1];
        pathWay.add(p);
        double startLat = p[1];
        double startLng = p[0];
        double endLat = p2[1];
        double endLng = p2[0];
        JsonFeatureCollection areas = new JsonFeatureCollection();

        CustomModel customModel = new CustomModel();
        for (int i = 0; i < params.getHardAreas().size(); i++) {
            int len = params.getHardAreas().get(i).getArea().length;
            String name = params.getHardAreas().get(i).getName();
            String conditionName = "in_" + name;
            System.out.println(name);
            System.out.println(conditionName);
            Coordinate[] area_1_coordinates = new Coordinate[len];
            for (int j = 0; j < len; j++) {
                area_1_coordinates[j] = new Coordinate(params.getHardAreas().get(i).getArea()[j][0], params.getHardAreas().get(i).getArea()[j][1]);
            }
            areas.getFeatures().add(
                    new JsonFeature(name,
                            "Feature",
                            null,
                            new GeometryFactory().createPolygon(area_1_coordinates),
                            new HashMap<>()));
            customModel.setAreas(areas);
            customModel.addToSpeed(If(conditionName, LIMIT, "0"));
        }
        GHRequest req = new GHRequest(startLat, startLng, endLat, endLng)
                .setCustomModel(customModel)
                .setProfile("car");

        GHResponse rsp = hopper.route(req);
        if (rsp.hasErrors()) {
            throw new RuntimeException(rsp.getErrors().toString());
        }
        ResponsePath path = rsp.getBest();
        PointList pointList = path.getPoints();
        for (int j = 0; j < pointList.size(); ++j) {
            JSONArray ja = new JSONArray();
            ja.add(pointList.getLon(j));
            ja.add(pointList.getLat(j));
            pathWay.add(ja);
        }

        pathWay.add(p2);
        distance += path.getDistance();
        timeInMs += path.getTime();//getTime（）是毫秒

        List<String> description = path.getDescription();
        InstructionList instr = path.getInstructions();
        // 返回最终结果
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("distance", distance + "米");
        jsonObject.put("time", timeInMs + "毫秒");
        jsonObject.put("path", pathWay);
        //获取导航提示
        jsonObject.put("instructions", instr);
        return jsonObject;
    }
}
