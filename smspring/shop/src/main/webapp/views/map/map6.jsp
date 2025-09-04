<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
  #map {
    width: 100%;
    height: 400px;
    border: 2px solid blue;
  }
  #roadview {
    width: 100%;
    height: 400px;
    border: 2px solid green;
    margin-top: 10px;
  }
</style>

<script>
  window.onload = function(){
    // 지도 컨테이너
    let mapContainer = document.getElementById('map');

    // 지도 옵션
    let mapOption = {
      center: new kakao.maps.LatLng(36.798818, 127.076250), // 중심 좌표
      level: 3 // 확대 레벨
    };

    // 지도 생성
    let map = new kakao.maps.Map(mapContainer, mapOption);

    // 로드뷰 컨테이너
    let roadviewContainer = document.getElementById('roadview');
    let roadview = new kakao.maps.Roadview(roadviewContainer);
    let roadviewClient = new kakao.maps.RoadviewClient();

    let position = new kakao.maps.LatLng(36.798818, 127.076250);

    // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰 실행
    roadviewClient.getNearestPanoId(position, 50, function(panoId) {
      roadview.setPanoId(panoId, position);
    });
  } // ← 여기 닫는 중괄호 빠져있었음
</script>

<div class="col-sm-10">
  <h2>map6</h2>
  <div id="map"></div>
  <div id="roadview"></div>
</div>
