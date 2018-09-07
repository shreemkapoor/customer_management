
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="resources/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${empsession.userName}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
 
    
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>
       
      <c:forEach items="${navUrl}" var="url">
         
         <c:if test="${fn:length(url.subList) == 0}">
         
          <li class="active ">
          <a href="${url.url}">
            <i class="fa fa-dashboard"></i> <span>${url.urlDesc}</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a> 
          
        </li>
         </c:if>
         <c:if test="${fn:length(url.subList) gt 0}">
         <li class="treeview">
          <a href="${url.url}">
            <i class="fa fa-laptop"></i>
            <span>${url.urlDesc}</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          <c:forEach items="${url.subList}" var="surl">
            <li><a href="${surl.subUrl}"><i class="fa fa-circle-o">
            </i> ${surl.subUrlDesc}</a></li>
           </c:forEach>
          </ul>
        </li>
        </c:if>
       <%--    <li class="active ">
           <a href="${url.url}">
            <i class="fa fa-files-o"></i>
            <span>${url.urlDesc}</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right">4</span>
            </span>
          </a>
          </li> --%>
          </c:forEach>
    </section>
  </aside>
  

