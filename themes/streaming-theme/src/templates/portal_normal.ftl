<!DOCTYPE html>
<#include init />
<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
    <title>${the_title} - ${company_name}</title>

    <meta content="initial-scale=1.0, width=device-width" name="viewport" />
    <#assign currentUrl = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />
    <meta property="og:url"           content="${currentUrl}" />
    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="${the_title} - ${company_name}" />
    <meta property="og:description"   content="Banco Central de Chile" />
    <meta property="og:image:url"     content="${images_folder}/social_media/logo-fb.jpg" />
    <meta property="fb:app_id" 				content="2580469875387422" />
    <link data-senna-track="temporary" href="${currentUrl}" rel="canonical">
    <link data-senna-track="temporary" href="${currentUrl}" hreflang="x-default" rel="alternate">
    <link data-senna-track="temporary" href="${currentUrl}" hreflang="es-ES" rel="alternate">
    <link data-senna-track="temporary" href="${currentUrl}" hreflang="en-US" rel="alternate">

    <#assign textoAnaliticHead = layout.getGroup().getExpandoBridge().getAttribute("CampoAnalitic")/>
    <#assign textoAnaliticBody = layout.getGroup().getExpandoBridge().getAttribute("CampoAnalitic2")/>
    <#assign mostrarAnaliticHead = layout.getGroup().getExpandoBridge().getAttribute("TagAnaliticHead")/>
    <#assign mostrarAnaliticBody = layout.getGroup().getExpandoBridge().getAttribute("TagAnaliticBody")/>


  <#assign noMostrarAnalitic = page.getExpandoBridge().getAttribute("quitaranaliticdepagina")/>
  <#assign put_fullCalendar = page.getExpandoBridge().getAttribute("agregarFullcalendar")/>

  <#assign paginaLogin = themeDisplay.getURLCurrent() />
  <#if !paginaLogin?contains("com_liferay_login_web_portlet_LoginPortlet") && !paginaLogin?contains("c/portal/login")>
    <#if mostrarAnaliticHead >
      <#if noMostrarAnalitic != true >
        ${textoAnaliticHead}
      </#if>
    </#if>
  </#if>
	<@liferay_util["include"] page=top_head_include />
</head>



<body class="${css_class}">
<#if !paginaLogin?contains("com_liferay_login_web_portlet_LoginPortlet") && !paginaLogin?contains("c/portal/login") >
  <#if mostrarAnaliticBody >

      <#if noMostrarAnalitic != true>
        ${textoAnaliticBody}
      </#if>
  </#if>
</#if>

<@liferay_ui["quick-access"] contentId="#main-content" />
<@liferay_util["include"] page=body_top_include />

<#if showcontrolmenu>
    <@liferay.control_menu />
</#if>

<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
		<div class="header-access">
			<div class="container-corp header-access-inner">
				<a href="#0" class="btn btn-minibox accebility-bar-aumentarFont"><i class="la la-plus"></i></a>
				<span class="basic-text px-2 c-white">A</span>
				<a href="#0" class="btn btn-minibox accebility-bar-disminuirFont"><i class="la la-minus"></i></a>
				<a href="#0" class="clean-link line-height-0 mx-2 accebility-bar-contraste"><i class="la la-adjust c-white fs-7"></i></a>

        <#assign wordLanguageId = "" />

        <#if w3c_language_id == "en-US" >
          <#assign palabraIdioma = "Portugues" />
        <#elseif w3c_language_id == "es-ES">
          <#assign palabraIdioma = "English" />
        </#if>

		<span id="actionIdioma" class="basic-text c-white sep-left-white pl-2 line-height-1">${wordLanguageId}</span>

        <span id="idioma">
				  <@liferay_portlet["runtime"] portletName="com_liferay_site_navigation_language_web_portlet_SiteNavigationLanguagePortlet"/>
        </span>

		</div>
		</div>
		<div class="header-main">
			<div class="header-main-inner container-corp">

				<div id="heading" class="header-main-logo">
					<h1 class="site-title">
						<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							<img alt="${logo_description}" src="${site_logo}" />
						</a>

					</h1>
				</div>
				<button class="c-hamburger c-hamburger--htx">
					<span></span>
				</button>

				<#if has_navigation && is_setup_complete>
					<#include "${full_templates_path}/navigation.ftl" />
				</#if>
          <div class="button-search-mobile">
              <i class="la la-search"></i>
          </div>
          <#if show_searchbar_header>
				  	<@liferay_portlet["runtime"] portletName="BcentralBuscador_INSTANCE_vNgjq95y7OiE"/>
					</#if>

			</div>
		</div>
	</header>

	<section id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>

</div>

<@liferay_portlet["runtime"] portletName="BcentralIdioma_INSTANCE_AbRLbwFIWxnb"/>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<script src="${js_slick}" type="text/javascript"></script>
<script src="${js_datepicker}" type="text/javascript"></script>
<script src="${js_aos}" type="text/javascript"></script>

<#if put_fullCalendar == true>
	<script src="${js_fullCalendar}" type="text/javascript"></script>
</#if>

<script src="${js_locale}" type="text/javascript"></script>
<script src="${js_functions}" type="text/javascript"></script>

</body>

</html>