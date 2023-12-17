<%@ include file="/init.jsp" %>

<portlet:resourceURL id="get-dashboard" var="get-dashboard" />
<portlet:resourceURL id="save-dashboard" var="save-dashboard" />

<div class="dashboard-content container">
    <h2><b><liferay-ui:message key="dashboard.caption"/></b></h2>
    <span class="dashboard-plus" onclick=""><i></i></span>
    <div class="dashboard-content-items"></div>
<div>

<script>
    let content = document.getElementsByClassName(
        ".dashboard-content-item");

    let getDashboard = '${get-dashboard}';
    let saveDashboard = '${save-dashboard}';

    let contentList = new ArrayList();

    const getDashboardItems = () => {
        const config = {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
        }

        async function fetchDashboard() {
            const response = await fetch(getDashboard, config)
                .then(([category, colorTheme, priority, title]) => {
                    content.append(
                        '<div class="dashboard-content-item">' +
                            '<div class="d-flex">' +
                                '<span class="dashboard-text-item">' +
                                    '<input type="text" name="category" value="' + category + '" />' +
                                '</span>' +
                            '</div>' +
                            '<div class="d-flex">' +
                                '<h3 class="dashboard-text-item">' + colorTheme + ' </h3>' +
                                '<i class="icon"></i></a>' +
                            '</div>' +
                            '<div class="d-flex">' +
                                '<span class="dashboard-radio-priority">' +
                                    '<input type="radio" name="priority" value=" ' + priority + '" />' +
                                '</span>' +
                            '</div>' +
                            '<div class="d-flex">' +
                                '<h3 class="dashboard-text-item">' + title + ' </h3>' +
                                '<i class="icon"></i></a>' +
                            '</div>' +
                        '</div>'
                    );
            })
            .catch((error) => {
                console.log(error);
            });
        }
    }

    const saveNewItemCarouselDashboard = (
      category,
      colorTheme,
      priority,
      saveDashboard,
      title
    ) => {
        let data = {
            "<portlet:namespace/>category":category,
            "<portlet:namespace/>colorTheme":colorTheme,
            "<portlet:namespace/>priority":priority,
            "<portlet:namespace/>title":title,
            "<portlet:namespace/>cmd":saveDashboard
        }

        const config = {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        }

        async function fetchDashboard() {
          const response = await fetch(saveDashboard, config);
          const dashboard = await response.json();

          console.log(dashboard, response);
        }
    }

</script>
