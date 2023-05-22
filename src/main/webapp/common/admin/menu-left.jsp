<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="sidebar" class="sidebar responsive">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>



	<ul class="nav nav-list">
		<li class=""><a href="index.html"> <i
				class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
					Dashboard </span>
		</a> <b class="arrow"></b></li>



		<li class="active open"><a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-list"></i> <span class="menu-text">
					Tables </span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li class="active"><a href="tables.html"> <i
						class="menu-icon fa fa-caret-right"></i> Simple &amp; Dynamic
				</a> <b class="arrow"></b></li>

				<li class=""><a href="jqgrid.html"> <i
						class="menu-icon fa fa-caret-right"></i> jqGrid plugin
				</a> <b class="arrow"></b></li>
			</ul></li>



		<li class=""><a href="gallery.html"> <i
				class="menu-icon fa fa-picture-o"></i> <span class="menu-text">
					Gallery </span>
		</a> <b class="arrow"></b></li>


	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>