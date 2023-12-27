<%@ include file="/init.jsp" %>

<%@ page import="java.util.List" %>

<%

List<Object> carouselData = (List<Object>) request.getAttribute("carouselData");
request.setAttribute("carouselData", carouselData);

%>

<!-- CDN BOOTSTRAP -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<div class="container">
    <div id="carouselStreaming" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators" id="carouselIndicators"></ol>
        <div class="carousel-inner" id="carouselInner"></div>
        <a class="carousel-control-prev" href="#carouselStreaming" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselStreaming" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>    
    </div>
</div>

<script>
    console.log('${carouselData}')
    
    let carousel = '${carouselData}';
    let carouselArray = JSON.parse(carousel);

    const carouselCategories = {};

    carouselArray.forEach((itemsList, index) => {
        console.log("itemsList ", itemsList, " index ", index);
        
        itemsList.forEach(items => {
            Object.keys(items).forEach(index => {
                const item = items[index];

                if (!carouselCategories[item.category]) {
                    console.log("dentro if se nao houver category ", item.category)
                    carouselCategories[item.category] = [];
                }
            
                carouselCategories[item.category].push(item);
                console.log("carouselCategories ", carouselCategories)
            });
        });
    });

    for (const category in carouselCategories) {
        console.log("category", category)
        const items = carouselCategories[category];
        console.log("itemsCategory ", items);
        const carouselIndicators = document.getElementById('carouselIndicators');
        const carouselInner = document.getElementById('carouselInner');

        items.forEach((item, index) => {
            console.log("item category", item)
            if (index % 4 === 0) {
                const indicator = document.createElement('li');
                indicator.setAttribute('data-target', `#${category}Carousel`);
                indicator.setAttribute('data-slide-to', index / 4);
                if (index === 0) indicator.classList.add('active');
                carouselIndicators.appendChild(indicator);

                const slide = document.createElement('div');
                slide.classList.add('carousel-item', 'row');
                if (index === 0) slide.classList.add('active');

                const slideItems = items.slice(index, index + 4);
                
                slideItems.forEach((slideItem, slideIndex) => {
                    console.log("slideItem ", slideItem)
                    slideIndex
                    const col = document.createElement('div');
                    col.classList.add('col-md-3');

                    const categoryElement = document.createElement('p');
                    categoryElement.classList.add('category');
                    categoryElement.textContent = slideItem.category;

                    const positionRelative = document.createElement('div');
                    positionRelative.classList.add('position-relative');

                    const image = document.createElement('img');
                    image.classList.add('d-block', 'w-100');
                    image.alt = `Slide ${index + slideIndex + 1}`;
                    image.src = slideItem.image;
                    console.log("slideItem.image", slideItem.image)

                    const carouselCaption = document.createElement('div');
                    carouselCaption.classList.add('carousel-caption', 'description', 'bg-dark', 'text-white', 'rounded');

                    const title = document.createElement('h5');
                    title.textContent = slideItem.title;

                    const description = document.createElement('p');
                    description.innerHTML = slideItem.description;

                    carouselCaption.appendChild(title);
                    carouselCaption.appendChild(description);

                    positionRelative.appendChild(image);
                    positionRelative.appendChild(carouselCaption);

                    col.appendChild(categoryElement);
                    col.appendChild(positionRelative);

                    slide.appendChild(col);
                });

                carouselInner.appendChild(slide);
            }
        });

        const imageContainers = document.querySelectorAll('.position-relative');

        imageContainers.forEach(container => {
            container.addEventListener('mouseover', () => {
                const description = container.querySelector('.description');
                description.style.display = 'block';
                const title = description.querySelector('h5');
                title.style.display = 'block';
            });

            container.addEventListener('mouseout', () => {
                const description = container.querySelector('.description');
                description.style.display = 'none';
                const title = description.querySelector('h5');
                title.style.display = 'none';
            });
        });
    }
</script>

<style>
    .container {
        max-width: 1800px;
        margin: 0 auto;
    }

    .carousel-item {
        position: relative;
        display: flex !important;
        width: 100%;
    }

    .carousel-item .row {
        flex-wrap: nowrap !important;
    }

    .img-carousel {
        position: absolute;
        height: 372.938px;
        width: 663px;
        background-color: rgba(0, 0, 0, 0.2);
    }

    .position-relative {
        position: relative;
        img {
            width: 100%;
            display: block;
        }
        .carousel-caption {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 0, 0.7);
            color: white;
            padding: 15px;
            display: none;
            h5 {
                margin-top: 10px;
                font-size: 18px;
            }
            p {
                font-size: 14px;
                margin-bottom: 0;
            }
        }
    }

</style>