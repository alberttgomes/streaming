# Courses Liferay

## Service Build

Service Build creates implementation classes for every defined entity's:
- Local Service
- Remove Service
- Model Class
- Entity Finders

The **only classes meant to be modified**
The **service must be regenerated** if implementation classes are modified.

## Finders

- Database querying methods
- Defined in the service.xml
- Automatically cache
- Two types:
  - Regular finders(without permission checks)
  - Filtered finders(with permission checks)
- Filtered finders are generated only if permission is enabling
- Finders can be customized in the entity-specific finder implementation classes.

## Service Context
A context object that aggregates information necessary for features used throughout
Liferay DXP's portlet and services, such as:
- Actions
- Request Parameters
- Classifications(tags and categories)
- Exceptions
- Scoping(company and group)
- Locale
- Request Object
- Permission-related information

## Caching

- Built-in caching support
- Three Levels
  - Entity
  - Finder
  - Hibernate
- Ehcache as the default cache provider for all the levels


## How to create a web model in Liferay DXP 

- In modular Liferay DXP applications, the **web module** contains the presentation layer
  - Ex: blogs-web in the native Blogs application
  - Typically, contains the following layers:
    - View (user interface)
    - Controller (portlet)

    
- Implementation Strategy
1. Create the web module
2. Implement portlet actions using MVC commands
3. Implement portlet JSPs using tag libraries
4. Implement portlet validation and feedback

- Liferay DXP provides several module templates for building the presentation layer:
  - mvc portlet: sample Liferay MVC portlet component, localization resources, JSP files
  - freemarker-portlet: used for UI with FreeMarker templating language and portlet back-end
  - NPM portlets: used for building UI with JS Frameworks; package management with NPM
  - spring-mvc-portlet: used for building a Spring MVC Portlet
  - war-mvc-portlet: used for legacy WAR-style portlets