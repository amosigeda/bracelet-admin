<%
	String pathl = request.getContextPath();
	String basePathl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathl+"/";
%>
		<!-- 本页面涉及的js函数，都在head.jsp页面中     -->
		<div id="sidebar" class="">

				<ul class="nav nav-list">
			
					<li class="active" id="fhindex">
						<a href="index">
							<i class="icon-home"></i><span>后台首页</span>
						</a>
					</li>
					<c:forEach items="${menuList}" var="menu">
						<li id="lm${menu.rescId }">
							<c:choose>
								<c:when test="${not empty menu.url }">
									<a style="cursor:pointer;" class="dropdown-toggle" target="mainFrame"  onclick="siMenu('z${menu.rescId }','lm${menu.rescId }','${menu.rescName }','${menu.url }')">
										<i class="${menu.icon}"></i>
										<span>${menu.rescName }</span>
									  </a>
								</c:when>
								<c:otherwise>
									<a style="cursor:pointer;" class="dropdown-toggle" >
										<i class="${menu.icon == null ? 'icon-desktop' : menu.icon}"></i>
										<span>${menu.rescName }</span>
										<b class="arrow icon-angle-down"></b>
									  </a>
								</c:otherwise>
							</c:choose>
							  <ul class="submenu">
									<c:forEach items="${menu.subRescs}" var="sub">
										<c:choose>
											<c:when test="${not empty sub.url}">
											<li id="z${sub.rescId }">
											<a style="cursor:pointer;" target="mainFrame"  onclick="siMenu('z${sub.rescId }','lm${menu.rescId }','${sub.rescName }','${sub.url }')"><i class="icon-double-angle-right"></i>${sub.rescName }</a></li>
											</c:when>
											<c:otherwise>
											<li><a href="javascript:void(0);"><i class="icon-double-angle-right"></i>${sub.rescName }</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
						  		</ul>
						</li>
					</c:forEach>
				</ul>
				<!--/.nav-list-->

				<div id="sidebar-collapse"><i class="icon-double-angle-left icon-double-angle-right"></i></div>

			</div><!--/#sidebar-->

