<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	<xsl:template match="/book">
{
	"title" : "<xsl:value-of select="@title"></xsl:value-of>",
	"author" : "<xsl:value-of select="author"></xsl:value-of>",
	"year" : <xsl:value-of select="year"></xsl:value-of>
}
	</xsl:template>
</xsl:stylesheet>