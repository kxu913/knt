<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
				
<xsl:output method="xml"/>

<xsl:template match="/">
    <html>
		<head>
			<xsl:copy-of select='root/head'/>
			<xsl:if test='//page/@theme'>
				<link rel="stylesheet" type="text/css">
					<xsl:attribute name='href'>/css/<xsl:value-of select='//page/@theme'/>/jquery-ui.css</xsl:attribute>
				</link>
			</xsl:if>
			
		</head>
		<body>
		    <script type="text/javascript">

    </script>
			<xsl:for-each select='root/page'>
				<xsl:apply-templates/>
			</xsl:for-each>
		</body>
	</html>
</xsl:template>

<xsl:template match="*">
	<xsl:copy-of select="."/>
</xsl:template>

<xsl:template name="getClass">
	<xsl:value-of select='@class'/>
	<!--
	<xsl:if test='not(@orientation)'> horizontal</xsl:if><xsl:if test='@orientation'> <xsl:value-of select='@orientation'/></xsl:if>
-->
</xsl:template>

<xsl:template name="getAttr">
	<xsl:if test='@name'>
		<xsl:attribute name='id'><xsl:value-of select='@name'/></xsl:attribute >
		<xsl:attribute name='name'><xsl:value-of select='@name'/></xsl:attribute >
	</xsl:if>
	<xsl:choose>
		<xsl:when test="@tooltip">
			<xsl:attribute name='title'><xsl:value-of select='@tooltip'/></xsl:attribute >
		</xsl:when>
		<xsl:otherwise>
			<xsl:attribute name='title'><xsl:value-of select='@caption'/></xsl:attribute >
		</xsl:otherwise>
	</xsl:choose>
	<xsl:if test="@align">
		<xsl:attribute name='align'><xsl:value-of select='@align'/></xsl:attribute >
	</xsl:if>
	<xsl:if test="@hrefTitle">
		<xsl:attribute name='hrefTitle'><xsl:value-of select='@hrefTitle'/></xsl:attribute >
	</xsl:if>
	
	<xsl:if test='@afterLoad'><xsl:attribute name='afterLoad'><xsl:value-of select='@afterLoad'/></xsl:attribute ></xsl:if>
</xsl:template>

<xsl:template name="getCSS">
	<xsl:comment>Auto generated</xsl:comment>
	<style>
	#<xsl:value-of select='@name'/> {
		<xsl:if test='@bkcolor'>
			background-color:<xsl:value-of select='@bkcolor'/>;
		</xsl:if>
		<xsl:if test='@height'>
			height:<xsl:value-of select='@height'/>;
		</xsl:if>
		<xsl:if test='@width'>
			width:<xsl:value-of select='@width'/>;
		</xsl:if>
		<xsl:if test='@color'>
			color:<xsl:value-of select='@color'/>;
		</xsl:if>	
		<xsl:if test='@border'>
			border:<xsl:value-of select='@border'/>;
		</xsl:if>
		<xsl:if test='@CSS'>
			<xsl:value-of select='@CSS'/>
		</xsl:if>
	}	
	</style>
	<xsl:comment>Auto generated end</xsl:comment>	
</xsl:template>

<xsl:template name="getDisplay">
	<xsl:attribute name='frameDiv'><xsl:value-of select='@name'/></xsl:attribute>
	<xsl:attribute name='parentDiv'><xsl:value-of select='../@name'/></xsl:attribute>
	<xsl:if test='../@orientation="horizontal"'><xsl:attribute name='horizontal'>1</xsl:attribute></xsl:if>
	<xsl:if test='@sortable="1"'><xsl:attribute name='sortable'>1</xsl:attribute></xsl:if>
	<xsl:attribute name='data'><xsl:value-of select='@data'/></xsl:attribute>
	<xsl:attribute name='divtype'><xsl:value-of select='name(.)'/></xsl:attribute>
</xsl:template>

<xsl:template name="getCSS1">
	<xsl:comment>Auto generated</xsl:comment>
	<style>
	#<xsl:value-of select='@name'/> {
		<xsl:if test='@CSS1'>
			<xsl:value-of select='@CSS1'/>
		</xsl:if>
	}	
	</style>
	<xsl:comment>Auto generated end</xsl:comment>	
</xsl:template>

<xsl:template name="getScript">
	<script>
		<xsl:comment>Auto generated</xsl:comment>	
				<xsl:if test='@width'>
					$("#<xsl:value-of select='@name'/>")
						.css("width",<xsl:value-of select='@width'/>)
						.css("min-width",<xsl:value-of select='@width'/>)
					</xsl:if>
				<xsl:if test='@height'>
					$("#<xsl:value-of select='@name'/>")
						.css("height",<xsl:value-of select='@height'/>)
				</xsl:if>		
				<xsl:if test='@min-width'>
					$("#<xsl:value-of select='@name'/>")
						.css("min-width",<xsl:value-of select='@width'/>)
					</xsl:if>
				<xsl:if test='@min-height'>
					$("#<xsl:value-of select='@name'/>")
						.css("min-height",<xsl:value-of select='@height'/>)
				</xsl:if>		

	<xsl:comment>Auto generated end</xsl:comment>			
	</script>	
</xsl:template>

<xsl:template match="panel">
	<xsl:call-template name="getCSS"/>
	<div >
		
		<xsl:call-template name="getDisplay"/>
		<xsl:attribute name="class">nopadding <xsl:call-template name='getClass'/></xsl:attribute>
		<xsl:call-template name="getAttr"/>
		<xsl:apply-templates/>
	</div>

	<xsl:call-template name="getScript"/>
	<xsl:if test='@load'>
		<script>
			loadLayout("<xsl:value-of select='@load'/>","#<xsl:value-of select='@name'/>");
		</script>
	</xsl:if>
</xsl:template>

<xsl:template match="button">
<xsl:call-template name="getCSS"/>
<a >
	<xsl:call-template name="getDisplay"/>
	<xsl:attribute name="class"><xsl:call-template name='getClass'/></xsl:attribute>
	<xsl:call-template name="getAttr"/><xsl:value-of select='@caption'/>
</a> 
	<script>
		$("#<xsl:value-of select='@name'/>")
			.button({<xsl:if test='@icon'>icons: {primary: "<xsl:value-of select='@icon'/>"}</xsl:if>})
			.click(function() { return <xsl:value-of select='@name'/>Click()});
	</script>
	<xsl:call-template name="getScript"/>	
</xsl:template>

<xsl:template match="imagebutton">

<div >
	<xsl:call-template name="getDisplay"/>
	<a class='nopadding'>
		<xsl:call-template name="getCSS"/>
		<img class='nopadding'>
		<xsl:call-template name="getAttr"/>
		<xsl:attribute name="class"> nopadding <xsl:call-template name='getClass'/></xsl:attribute>
		
			<xsl:attribute name='src'><xsl:value-of select='@src'/></xsl:attribute>
		</img>
	</a>
</div>	
<!--
	<script>
		$("#<xsl:value-of select='@name'/>")
			.button()
			.click(function() { alert("<xsl:value-of select='@caption'/>");});
	</script>	

	<xsl:call-template name="getScript"/>
		-->
</xsl:template>

<xsl:template match="link">

<div >
<xsl:call-template name="getDisplay"/>
	<xsl:call-template name="getCSS"/>

	<a >
		<xsl:attribute name="href"><xsl:value-of select='@link'/> </xsl:attribute>

		<img >
			<xsl:attribute name="class"> <xsl:call-template name='getClass'/></xsl:attribute>
			<xsl:call-template name="getAttr"/>
			<xsl:attribute name='src'><xsl:value-of select='@src'/></xsl:attribute>
		</img>
		
	</a>
	<xsl:apply-templates/>
</div>	
	<xsl:call-template name="getScript"/>
</xsl:template>


<xsl:template match="searchbox">
	<xsl:comment>to be optimized!!!!</xsl:comment>
   <form method="get" class="searchform ui-widget-header" action="javascript:alert($('#s'))"  style="height:1.8em;display:inline-block;position:relative;top:5px;width:220px;" >
		<xsl:call-template name="getDisplay"/>
		<xsl:call-template name="getAttr"/>
		<input clas="ui-widget-header" type="text" name="s" value="" placeholder="Search" style="height:1.5em;width:185px;float:left;top:2px;padding:0;margin:0 0;border:0;top:1px;position:relative" />
		<button type="submit" class="icon-search" style="position:relative;top:4px;float:left;background-color:transparent;"></button>
	</form>
	<script>
		$(".icon-search").button({icons: {primary: "ui-icon-search"},text:false});
		$(".searchform").addClass("ui-widget-header");
</script>
<xsl:call-template name="getScript"/>
</xsl:template>

<xsl:template match="menu">
	<xsl:call-template name="getCSS"/>
	<ul style="display:inline-block" >
	<xsl:call-template name="getDisplay"/>
		
		<xsl:attribute name="class"> <xsl:if test='@ispopup="1"'>popup</xsl:if> nopadding <xsl:call-template name='getClass'/></xsl:attribute>
		<xsl:call-template name="getAttr"/>
		<xsl:apply-templates/>
	</ul>
	<script>
		$("#<xsl:value-of select='@name'/>")
			.menu( <xsl:if test='@ispopup="1"'>{position: { my: 'left top', at: 'left bottom' }}</xsl:if>);
	</script>
	<xsl:call-template name="getScript"/>
</xsl:template>

<xsl:template match="navMenuBar1">
	<xsl:call-template name="getCSS"/>
	<div  style="display:inline-block" >
	<xsl:call-template name="getDisplay"/>
		<xsl:attribute name="class"> nopadding <xsl:call-template name='getClass'/></xsl:attribute>
		<xsl:call-template name="getAttr"/>
		<xsl:for-each select="menuitem">
			<h3><xsl:call-template name="getAttr"/> <a href="#"> 			<xsl:if test='@caption'>
				<xsl:value-of select='@caption'/>
			</xsl:if>
			<xsl:if test='not(@caption)'>
				<xsl:value-of select='@name'/>
			</xsl:if>
			
			</a> </h3>
			<div> <ul><xsl:apply-templates/></ul></div>
		</xsl:for-each>
	</div>
	<script>
		$("#<xsl:value-of select='@name'/>")
			.accordion({
        collapsible: true,
        navigation: true,
        clearStyle: true,
		heightStyle:"content",
		"icons":null 
    });
	</script>
	<xsl:call-template name="getScript"/>
</xsl:template>

<xsl:template match="navMenuBar">
	<xsl:call-template name="getCSS"/>
	<div  style="display:inline-block" >
	<xsl:call-template name="getDisplay"/>
		<xsl:attribute name="class"> nopadding <xsl:call-template name='getClass'/></xsl:attribute>
		<xsl:call-template name="getAttr"/>
		<xsl:apply-templates/>
	</div>
	<script>
		$("#<xsl:value-of select='@name'/>")
			.accordion({
        collapsible: true,
        navigation: true,
        clearStyle: true,
		heightStyle:"content",
		"icons":null ,
		header: "> div > h3"
    })   
	</script>
	<xsl:call-template name="getScript"/>
</xsl:template>

<xsl:template match="menuitem[name(..)='navMenuBar']">
<div>
   			<h3><xsl:call-template name="getAttr"/> <a href="#"> 			<xsl:if test='@caption'>
				<xsl:value-of select='@caption'/>
			</xsl:if>
			<xsl:if test='not(@caption)'>
				<xsl:value-of select='@name'/>
			</xsl:if>
			
			</a> </h3>
			<div> <ul><xsl:apply-templates/></ul></div>
			</div>
</xsl:template>



<xsl:template match="menuitem">
    <li>
		<xsl:call-template name="getDisplay"/>
		<xsl:attribute name="class"> nopadding <xsl:call-template name='getClass'/></xsl:attribute>
		<xsl:call-template name="getAttr"/>
		<a href="#" style='text-align: left;'>
			<xsl:if test='@icon'>
				<span><xsl:attribute name='class'>ui-icon <xsl:value-of select='@icon'/></xsl:attribute></span>
			</xsl:if>
			<xsl:if test='@caption'>
				<xsl:value-of select='@caption'/>
			</xsl:if>
			<xsl:if test='not(@caption)'>
				<xsl:value-of select='@name'/>
			</xsl:if>
		</a>
		<xsl:if test="menuitem">
		    <ul>
				<xsl:apply-templates/>
			</ul>
		</xsl:if>
	</li>
</xsl:template>

<xsl:template match="tabPage">
<div >
<xsl:call-template name="getDisplay"/>
<xsl:attribute name="class"> nopadding <xsl:call-template name='getClass'/></xsl:attribute>
<xsl:call-template name="getAttr"/>
	<ul childEntry='1'>
		<xsl:apply-templates/>
	</ul>
	</div>
	<script>

		$("#<xsl:value-of select='@name'/>").tabs()
		<xsl:if test="@orientation='vertical'">	
			.addClass( "ui-tabs-vertical ui-helper-clearfix" );
			//$( "#<xsl:value-of select='@name'/> li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
		</xsl:if>

	</script>
</xsl:template>

<xsl:template match="tab">
	<li>
	<xsl:call-template name="getDisplay"/>
	<a>
	<xsl:attribute name='href'><xsl:value-of select='@link'/></xsl:attribute >
	<xsl:value-of select='@caption'/>
	</a>
	</li>
</xsl:template>


</xsl:stylesheet>