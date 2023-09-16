<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="streaming.caption"/></b>
</p>

<p>Launch</p>

<script type="text/javascript">
    let carouselData = "${carouselContentModel}";

    console.log("Carousel Portlet Data \n", carouselData);
</script>