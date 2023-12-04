<%@ include file="/init.jsp" %>

<%

Object carouselData = (Object)request.getAttribute("carouselData");

%>

<p><b><liferay-ui:message key="streaming.caption"/></b></p>

<img id="image-carousel" src="" class="d-block w-100" alt="image" />

<!--
<div id="container">
    <react:component
        module="streaming-frontend/StreamingView"
        props="<%= carouselData %>"
    />
</div>
-->

<script>
    let carouselDataEval = ${carouselData};

    let jsonObject = eval(carouselDataEval);

    jsonObject.map((value, index) => {
        document.getElementById("image-carousel").setAttribute("src",  value.image);

        console.log(value.Color64500276, index);
    })

    console.log(jsonObject)
</script>