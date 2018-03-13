<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	<xsl:variable name="currentYear" select="format-date(current-date(), '[Y0001]')"/>
	<xsl:template match="/books">
{
		<xsl:for-each select="book">
			<xsl:value-of select="year"></xsl:value-of>
			<xsl:value-of select="$currentYear"></xsl:value-of>
			<xsl:value-of select="year + 1"></xsl:value-of>
			<xsl:if test="(year + 50) &lt; number($currentYear)">
	{
		"title" : "<xsl:value-of select="@title"></xsl:value-of>",
		"author" : "<xsl:value-of select="author"></xsl:value-of>",
		"year" : <xsl:value-of select="year"></xsl:value-of>
	}
			</xsl:if>
		</xsl:for-each>
{
	</xsl:template>
</xsl:stylesheet>