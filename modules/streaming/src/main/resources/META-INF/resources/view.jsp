<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="streaming.caption"/></b>
</p>

<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
  <p>Category Session</p>

  <div class="carousel-inner">
    <div class="carousel-item active">
        <img src="${url-file-entry}" class="d-block w-100" alt="image-carousel">
        <span class="carousel-control-title" aria-hidden="true">"${title}"</span>
        <span class="carousel-control-description" aria-hidden="true">"${title}"</span>
    </div>

    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>

    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>

</div>

<script type="text/javascript">
    let carouselData = "${carouselContentModel}";

    console.log("Carousel Portlet Data \n", carouselData);
</script>