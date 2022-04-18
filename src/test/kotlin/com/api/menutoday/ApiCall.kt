package com.api.menutoday

import com.api.menutoday.common.util.http.HttpUtilImpl
import com.api.menutoday.common.util.http.model.HttpRequest
import com.api.menutoday.config.ObjectMapperConfig
import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

//@Disabled
// 외부api의 데이터를 확인할려고 하는 것이니 실제 테스트와 관련 없습니다.
class ApiCall {

    fun objectMapper(): ObjectMapper {
        return ObjectMapperConfig().objectMapper()
    }
//    @Test
//    fun apiCall(){
//
//        var keyword : String = "신사동 567-28 치킨"
//        try {
//            keyword = URLEncoder.encode(keyword, "UTF-8");
//        } catch (e : UnsupportedEncodingException) {
//            throw RuntimeException("encoding fail!",e);
//        }
//        val request = HttpRequest(
//            url = "https://openapi.naver.com/v1/search/local.json?query=$keyword&display=20&start=1&sort=random"
//        )
//            .addHeader("X-Naver-Client-Id","")
//            .addHeader("X-Naver-Client-Secret","")
//
//        val http = HttpUtilImpl()
//        val response = http.get(request)
//
//
//    }

    @Test
    fun apiCalladress(){
        var address : String = "논현로159길 18"

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/address.json"
        )
            .addHeader("Authorization","KakaoAK ")
            .addParam("query", address, Charsets.UTF_8)


        val http = HttpUtilImpl()
        val response = http.get(request)

        assertThat(response.code,`is`(HttpStatus.OK.value()))

    }

    @Test
    fun apiCallk(){
        var keyword : String = "치킨"

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/keyword.json"
        )
            .addHeader("Authorization","KakaoAK ")
            .addParam("y",37.5231498089109)
            .addParam("x",127.026612890604)
            .addParam("radius",500)
            .addParam("category_group_code","FD6")
            .addParam("query", keyword, Charsets.UTF_8)


        val http = HttpUtilImpl()
        val response = http.get(request)

        assertThat(response.code,`is`(HttpStatus.OK.value()))

    }
    /*
    {"documents":[{"address_name":"서울 강남구 신사동 547-6","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨 \u003e 깐부치킨","distance":"317","id":"1037406962","phone":"02-3445-3344","place_name":"깐부치킨 신사가로수점","place_url":"http://place.map.kakao.com/1037406962","road_address_name":"서울 강남구 압구정로14길 12","x":"127.02304584578","y":"37.5235128519267"},{"address_name":"서울 강남구 신사동 566-35","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨 \u003e BHC치킨","distance":"100","id":"26430344","phone":"02-547-0875","place_name":"BHC치킨 압구정역점","place_url":"http://place.map.kakao.com/26430344","road_address_name":"서울 강남구 논현로157길 8","x":"127.02740758014552","y":"37.52250279740616"},{"address_name":"서울 강남구 신사동 567-21","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨 \u003e 깐부치킨","distance":"56","id":"17738185","phone":"02-547-8292","place_name":"깐부치킨 압구정현대백화점점","place_url":"http://place.map.kakao.com/17738185","road_address_name":"서울 강남구 논현로161길 11","x":"127.02719973894337","y":"37.52334618388149"},{"address_name":"서울 강남구 신사동 597-1","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨","distance":"226","id":"1639839122","phone":"02-518-4174","place_name":"조스파이시치킨","place_url":"http://place.map.kakao.com/1639839122","road_address_name":"서울 강남구 압구정로30길 63","x":"127.029168070419","y":"37.5232411978856"},{"address_name":"서울 강남구 신사동 569-26","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨 \u003e 네네치킨","distance":"63","id":"1443975193","phone":"050-7964-1038","place_name":"네네치킨 신사점","place_url":"http://place.map.kakao.com/1443975193","road_address_name":"서울 강남구 논현로161길 14","x":"127.027064076362","y":"37.5235876837192"},{"address_name":"서울 강남구 신사동 597-1","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨","distance":"227","id":"14596913","phone":"02-518-4174","place_name":"스파이 스치킨 압구정점","place_url":"http://place.map.kakao.com/14596913","road_address_name":"서울 강남구 압구정로30길 63","x":"127.029181650995","y":"37.5232556105716"},{"address_name":"서울 강남구 신사동 533-9","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨","distance":"409","id":"720272373","phone":"02-541-4888","place_name":"빙닭","place_url":"http://place.map.kakao.com/720272373","road_address_name":"서울 강남구 가로수길 57-6","x":"127.022262535554","y":"37.5218821874006"},{"address_name":"서울 강남구 압구정동 426","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨","distance":"313","id":"14512239","phone":"","place_name":"나라라파닭치킨 압구정동점","place_url":"http://place.map.kakao.com/14512239","road_address_name":"서울 강남구 압구정로 151","x":"127.02483843906","y":"37.5255992099797"},{"address_name":"서울 강남구 신사동 608-2","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 치킨","distance":"437","id":"841281576","phone":"02-544-6228","place_name":"부어치킨 압구정점","place_url":"http://place.map.kakao.com/841281576","road_address_name":"서울 강남구 압구정로32길 25","x":"127.029984816484","y":"37.5260322985626"},{"address_name":"서울 강남구 신사동 549-9","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 술집 \u003e 호프,요리주점","distance":"294","id":"12250697","phone":"02-541-0969","place_name":"한잔의추억","place_url":"http://place.map.kakao.com/12250697","road_address_name":"서울 강남구 논현로175길 68","x":"127.023475888268","y":"37.5240461606931"},{"address_name":"서울 강남구 신사동 550-8","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 양식 \u003e 햄버거","distance":"262","id":"402310476","phone":"02-546-5508","place_name":"세인트그릴","place_url":"http://place.map.kakao.com/402310476","road_address_name":"서울 강남구 논현로175길 63","x":"127.02385825036104","y":"37.524035272043434"},{"address_name":"서울 강남구 신사동 603-1","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 중식 \u003e 중화요리","distance":"312","id":"46433934","phone":"02-511-1162","place_name":"시추안하우스 압구정점","place_url":"http://place.map.kakao.com/46433934","road_address_name":"서울 강남구 논현로 854","x":"127.028865697479","y":"37.5253207856728"},{"address_name":"서울 강남구 신사동 541-2","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 술집 \u003e 와인바","distance":"478","id":"8152575","phone":"02-541-4427","place_name":"헬로우","place_url":"http://place.map.kakao.com/8152575","road_address_name":"서울 강남구 논현로151길 55","x":"127.02373350698598","y":"37.51950145120361"},{"address_name":"서울 강남구 신사동 524-31","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 양식 \u003e 피자","distance":"441","id":"936257574","phone":"070-7757-9200","place_name":"피자익스프레스","place_url":"http://place.map.kakao.com/936257574","road_address_name":"서울 강남구 압구정로10길 28","x":"127.021927657229","y":"37.5217615156762"},{"address_name":"서울 강남구 신사동 542-6","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 아시아음식","distance":"490","id":"554832363","phone":"","place_name":"감성아시아","place_url":"http://place.map.kakao.com/554832363","road_address_name":"서울 강남구 가로수길 26","x":"127.02325279134","y":"37.5196312912695"}],"meta":{"is_end":false,"pageable_count":29,"same_name":{"keyword":"치킨","region":[],"selected_region":""},"total_count":29}}
     */

    @Test
    fun apiCallCate(){

        val request = HttpRequest(
            url = "https://dapi.kakao.com/v2/local/search/category.json"
        )
            .addHeader("Authorization","KakaoAK ")
            .addParam("y",37.514322572335935)
            .addParam("x",127.06283102249932)
            .addParam("radius",500)
            .addParam("category_group_code","FD6")
//            .addParam("query", keyword, Charsets.UTF_8)



        val http = HttpUtilImpl()
        val response = http.get(request)

        assertThat(response.code,`is`(HttpStatus.OK.value()))

    }
    /*
    {"documents":[{"address_name":"서울 강남구 삼성동 76-10","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 한식 \u003e 육류,고기 \u003e 곱창,막창","distance":"360","id":"8664636","phone":"02-511-0068","place_name":"곰바위","place_url":"http://place.map.kakao.com/8664636","road_address_name":"서울 강남구 영동대로115길 10","x":"127.05880695418199","y":"37.51486885062181"},{"address_name":"서울 강남구 삼성동 148-15","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 중식","distance":"618","id":"1770731230","phone":"0507-1374-3082","place_name":"팀호완 삼성점","place_url":"http://place.map.kakao.com/1770731230","road_address_name":"서울 강남구 봉은사로86길 30","x":"127.056847505366","y":"37.5114270736423"},{"address_name":"서울 강남구 대치동 996-16","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 한식 \u003e 해장국","distance":"710","id":"27531028","phone":"02-558-7905","place_name":"중앙해장","place_url":"http://place.map.kakao.com/27531028","road_address_name":"서울 강남구 영동대로86길 17","x":"127.065472540919","y":"37.508273597184"},{"address_name":"서울 강남구 삼성동 159","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 양식 \u003e 해산물 \u003e 바닷가재","distance":"400","id":"1986314222","phone":"1644-4446","place_name":"바이킹스워프 코엑스점","place_url":"http://place.map.kakao.com/1986314222","road_address_name":"서울 강남구 영동대로 513","x":"127.05882781561417","y":"37.51262534052336"},{"address_name":"서울 강남구 삼성동 165-12","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 한식 \u003e 설렁탕","distance":"165","id":"16649489","phone":"02-569-8726","place_name":"이남장 삼성점","place_url":"http://place.map.kakao.com/16649489","road_address_name":"서울 강남구 봉은사로108길 21","x":"127.064450126559","y":"37.5135684607614"},{"address_name":"서울 강남구 대치동 996-17","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 양식 \u003e 햄버거","distance":"621","id":"586363951","phone":"02-566-6244","place_name":"크라이치즈버거 삼성역점","place_url":"http://place.map.kakao.com/586363951","road_address_name":"서울 강남구 테헤란로 616","x":"127.06518140830931","y":"37.50904501817143"},{"address_name":"서울 강남구 삼성동 58-6","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 한식 \u003e 육류,고기","distance":"767","id":"27512695","phone":"02-518-9710","place_name":"길목","place_url":"http://place.map.kakao.com/27512695","road_address_name":"서울 강남구 영동대로129길 10","x":"127.0564630117036","y":"37.519026323125196"},{"address_name":"서울 강남구 삼성동 160-18","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 한식 \u003e 해물,생선 \u003e 게,대게","distance":"107","id":"16056083","phone":"02-561-8788","place_name":"꽃지 삼성점","place_url":"http://place.map.kakao.com/16056083","road_address_name":"서울 강남구 봉은사로 610","x":"127.061622900452","y":"37.5142078803163"},{"address_name":"서울 강남구 삼성동 146-23","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 양식 \u003e 햄버거","distance":"668","id":"18377454","phone":"02-555-7180","place_name":"브루클린더버거조인트 삼성점","place_url":"http://place.map.kakao.com/18377454","road_address_name":"서울 강남구 봉은사로84길 10","x":"127.0555815850631","y":"37.51260889258207"},{"address_name":"서울 강남구 삼성동 154-11","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 중식 \u003e 중화요리","distance":"667","id":"24041168","phone":"02-508-1320","place_name":"시추안하우스 삼성점","place_url":"http://place.map.kakao.com/24041168","road_address_name":"서울 강남구 테헤란로87길 29","x":"127.058130993444","y":"37.5096145291272"},{"address_name":"서울 강남구 삼성동 151-7","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 한식 \u003e 냉면","distance":"825","id":"27261403","phone":"02-569-8939","place_name":"능라도 강남점","place_url":"http://place.map.kakao.com/27261403","road_address_name":"서울 강남구 삼성로 534","x":"127.05553416938561","y":"37.509677046854954"},{"address_name":"서울 강남구 삼성동 158-9","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 양식 \u003e 이탈리안","distance":"718","id":"8969599","phone":"02-561-9011","place_name":"마노디셰프 삼성점","place_url":"http://place.map.kakao.com/8969599","road_address_name":"서울 강남구 테헤란로87길 21","x":"127.05809098109505","y":"37.50906493601977"},{"address_name":"서울 강남구 삼성동 158-10","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 양식 \u003e 스테이크,립","distance":"717","id":"19514179","phone":"02-552-6647","place_name":"붓처스컷 삼성점","place_url":"http://place.map.kakao.com/19514179","road_address_name":"서울 강남구 테헤란로87길 17","x":"127.058505908235","y":"37.5088575001708"},{"address_name":"서울 강남구 대치동 999","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 일식 \u003e 돈까스,우동","distance":"739","id":"10042991","phone":"0507-1489-9805","place_name":"후레쉬빌 삼성역본점","place_url":"http://place.map.kakao.com/10042991","road_address_name":"서울 강남구 테헤란로108길 19","x":"127.066264232804","y":"37.5082479275874"},{"address_name":"서울 강남구 삼성동 78","category_group_code":"FD6","category_group_name":"음식점","category_name":"음식점 \u003e 중식 \u003e 중화요리","distance":"775","id":"1498098673","phone":"02-543-4448","place_name":"더라운드 삼성점","place_url":"http://place.map.kakao.com/1498098673","road_address_name":"서울 강남구 영동대로 648","x":"127.057672974866","y":"37.5199726926885"}],"meta":{"is_end":false,"pageable_count":45,"same_name":null,"total_count":1088}}
     */

}