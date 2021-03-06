package cn.org.rapid_framework.generator.provider.db.model;



import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.util.ActionScriptDataTypesUtils;
import cn.org.rapid_framework.generator.util.DatabaseDataTypesUtils;
import cn.org.rapid_framework.generator.util.GLogger;
import cn.org.rapid_framework.generator.util.JdbcType;
import cn.org.rapid_framework.generator.util.StringHelper;
import cn.org.rapid_framework.generator.util.TestDataGenerator;
/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */
public class Column {
	/**
	 * Reference to the containing table
	 */
	private Table _table;

	/**
	 * The java.sql.Types type
	 */
	private int _sqlType;

	/**
	 * The sql typename. provided by JDBC driver
	 */
	private String _sqlTypeName;

	/**
	 * The name of the column
	 */
	private String _sqlName;

	/**
	 * True if the column is a primary key
	 */
	private boolean _isPk;

	/**
	 * True if the column is a foreign key
	 */
	private boolean _isFk;

	/**
	 * @todo-javadoc Describe the column
	 */
	private int _size;

	/**
	 * @todo-javadoc Describe the column
	 */
	private int _decimalDigits;

	/**
	 * True if the column is nullable
	 */
	private boolean _isNullable;

	/**
	 * True if the column is indexed
	 */
	private boolean _isIndexed;

	/**
	 * True if the column is unique
	 */
	private boolean _isUnique;

	/**
	 * Null if the DB reports no default value
	 */
	private String _defaultValue;
	
	/**
	 * The comments of column
	 */
	private String _remarks;
	
	
	
	
    private String htmlInputType;// 控件类型 下拉框 日期 文本框

	private String dictName;// 业务字典名

	private boolean dictHasNull;// 可以为空

	private String dictNullLable;// 为空显示名

	private boolean readOnly;// 只读

	private String  columnOrder;//数据库顺序
	
	private String  columncHtmlOrder;//页面顺序

	private String jsValidateName;// 效验数据类型

	private String displayFormat;// 日期显示格式

	private String parseFormat;// 日期数据库格式

	private String querySqlOperator;// 数据库操作 = like < >

	private String querySqlLikeRule; // center left right
	
	
	
	/**
	 * Get static reference to Log4J Logger
	 */

//	String description;
//
//	String humanName;
//
//	int order;
//
//	boolean isHtmlHidden;
//
//	String validateString;

	
	
	/**
	 * Describe what the DbColumn constructor does
	 * 
	 * @param table
	 *            Describe what the parameter does
	 * @param sqlType
	 *            Describe what the parameter does
	 * @param sqlTypeName
	 *            Describe what the parameter does
	 * @param sqlName
	 *            Describe what the parameter does
	 * @param size
	 *            Describe what the parameter does
	 * @param decimalDigits
	 *            Describe what the parameter does
	 * @param isPk
	 *            Describe what the parameter does
	 * @param isNullable
	 *            Describe what the parameter does
	 * @param isIndexed
	 *            Describe what the parameter does
	 * @param defaultValue
	 *            Describe what the parameter does
	 * @param isUnique
	 *            Describe what the parameter does
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for constructor
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for method parameter
	 */
	public Column(Table table, int sqlType, String sqlTypeName,
			String sqlName, int size, int decimalDigits, boolean isPk,
			boolean isNullable, boolean isIndexed, boolean isUnique,
			String defaultValue,String remarks) {
		_table = table;
		_sqlType = sqlType;
		_sqlName = sqlName;
		_sqlTypeName = sqlTypeName;
		_size = size;
		_decimalDigits = decimalDigits;
		_isPk = isPk;
		_isNullable = isNullable;
		_isIndexed = isIndexed;
		_isUnique = isUnique;
		_defaultValue = defaultValue;
		_remarks = remarks;
		
		GLogger.debug(sqlName + " isPk -> " + _isPk);

	}

	public Column() {
	}
	
	/**
	 * Gets the SqlType attribute of the Column object
	 * 
	 * @return The SqlType value
	 */
	public int getSqlType() {
		return _sqlType;
	}

	/**
	 * Gets the Table attribute of the DbColumn object
	 * 
	 * @return The Table value
	 */
	public Table getTable() {
		return _table;
	}

	/**
	 * Gets the Size attribute of the DbColumn object
	 * 
	 * @return The Size value
	 */
	public int getSize() {
		return _size;
	}

	/**
	 * Gets the DecimalDigits attribute of the DbColumn object
	 * 
	 * @return The DecimalDigits value
	 */
	public int getDecimalDigits() {
		return _decimalDigits;
	}

	/**
	 * Gets the SqlTypeName attribute of the Column object
	 * 
	 * @return The SqlTypeName value
	 */
	public String getSqlTypeName() {
		return _sqlTypeName;
	}

	/**
	 * Gets the SqlName attribute of the Column object
	 * 
	 * @return The SqlName value
	 */
	public String getSqlName() {
		return _sqlName;
	}

	public String getUnderscoreName() {
		return getSqlName().toLowerCase();
	}
	
	/**
	 * Gets the Pk attribute of the Column object
	 * 
	 * @return The Pk value
	 */
	public boolean isPk() {
		return _isPk;
	}

	/**
	 * Gets the Fk attribute of the Column object
	 * 
	 * @return The Fk value
	 */
	public boolean isFk() {
		return _isFk;
	}

	/**
	 * Gets the Nullable attribute of the Column object
	 * 
	 * @return The Nullable value
	 */
	public  boolean isNullable() {
		return _isNullable;
	}

	/**
	 * Gets the Indexed attribute of the DbColumn object
	 * 
	 * @return The Indexed value
	 */
	public  boolean isIndexed() {
		return _isIndexed;
	}

	/**
	 * Gets the Unique attribute of the DbColumn object
	 * 
	 * @return The Unique value
	 */
	public boolean isUnique() {
		return _isUnique;
	}

	/**
	 * Gets the DefaultValue attribute of the DbColumn object
	 * 
	 * @return The DefaultValue value
	 */
	public  String getDefaultValue() {
		return _defaultValue;
	}
	
	public  String getRemarks() {
		return _remarks;
	}

	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	public int hashCode() {
		return (getTable().getSqlName() + "#" + getSqlName()).hashCode();
	}

	/**
	 * Describe what the method does
	 * 
	 * @param o
	 *            Describe what the parameter does
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for return value
	 */
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o instanceof Column) {
			Column other = (Column)o;
			if(getSqlName().equals(other.getSqlName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	public String toString() {
		return getSqlName();
	}

	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	protected  String prefsPrefix() {
		return "tables/" + getTable().getSqlName() + "/columns/" + getSqlName();
	}

	/**
	 * Sets the Pk attribute of the DbColumn object
	 * 
	 * @param flag
	 *            The new Pk value
	 */
	void setFk(boolean flag) {
		_isFk = flag;
	}
	
	public String getColumnName() {
		return StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(getSqlName()));
	}
	
	public String getColumnNameFirstLower() {
		return StringHelper.uncapitalize(getColumnName());
	}
	
	public String getColumnNameLowerCase() {
		return getColumnName().toLowerCase();
	}
	/**
	 * @deprecated use getColumnNameFirstLower() instead
	 */
	public String getColumnNameLower() {
		return getColumnNameFirstLower();
	}
	
	public String getJdbcSqlTypeName() {
		String result = JdbcType.getJdbcSqlTypeName(getSqlType());
		//if(result == null) throw new RuntimeException("jdbcSqlTypeName is null column:"+getSqlName()+" sqlType:"+getSqlType());
		return result;
	}
	
	public String getColumnAlias() {
		return StringHelper.emptyIf(getRemarks(), getColumnNameFirstLower());
	}
	
	public String getConstantName() {
		return StringHelper.toUnderscoreName(getSqlName()).toUpperCase();
	}
	
	public boolean getIsNotIdOrVersionField() {
		return !isPk();
	}
	
	public String getValidateString() {
		String result = getNoRequiredValidateString();
		if(!isNullable()) {
			result = "required " + result;
		}
		return result;
	}
	
	public String getNoRequiredValidateString() {
		String result = "";
		if(getSqlName().indexOf("mail") >= 0) {
			result += "validate-email ";
		}
		if(DatabaseDataTypesUtils.isFloatNumber(getSqlType(), getSize(), getDecimalDigits())) {
			result += "validate-number ";
		}
		if(DatabaseDataTypesUtils.isIntegerNumber(getSqlType(), getSize(), getDecimalDigits())) {
			result += "validate-integer ";
			if(getJavaType().indexOf("Short") >= 0) {
				result += "max-value-"+Short.MAX_VALUE;
			}else if(getJavaType().indexOf("Integer") >= 0) {
				result += "max-value-"+Integer.MAX_VALUE;
			}else if(getJavaType().indexOf("Byte") >= 0) {
				result += "max-value-"+Byte.MAX_VALUE;
			}
		}
//		if(DatabaseDataTypesUtils.isDate(getSqlType(), getSize(), getDecimalDigits())) {
//			result += "validate-date ";
//		}
		if(DatabaseDataTypesUtils.isString(getSqlType(), getSize(), getDecimalDigits())) {
			result += "max-length-"+getSize();
		}

		return result;
	}
	
	public boolean getIsStringColumn() {
		return DatabaseDataTypesUtils.isString(getSqlType(), getSize(), getDecimalDigits());
	}
	
	public boolean getIsDateTimeColumn() {
		return DatabaseDataTypesUtils.isDate(getSqlType(), getSize(), getDecimalDigits());
	}
	
	public boolean getIsNumberColumn() {
		return DatabaseDataTypesUtils.isFloatNumber(getSqlType(), getSize(), getDecimalDigits()) || DatabaseDataTypesUtils.isIntegerNumber(getSqlType(), getSize(), getDecimalDigits());
	}
	/** 检查是否包含某些关键字,关键字以逗号分隔 */
	public boolean contains(String keywords) {
		if(keywords == null) throw new IllegalArgumentException("'keywords' must be not null");
		return StringHelper.contains(getSqlName(), keywords.split(","));
	}
	
	public boolean isHtmlHidden() {
		return isPk() && _table.isSingleId();
	}
	
	/**
	 * 得到对应的javaType,如java.lang.String,
	 * @return
	 */
	public String getJavaType() {
		String normalJdbcJavaType = DatabaseDataTypesUtils.getPreferredJavaType(getSqlType(), getSize(), getDecimalDigits());
		return GeneratorProperties.getProperty("java_typemapping."+normalJdbcJavaType,normalJdbcJavaType).trim();
	}
	
	/**
	 * 得到简短的java.lang.javaType,如java.lang.String将返回String,而非java.lang包的,将直接返回getJavaType()
	 * @return
	 */
	public String getSimpleJavaType() {
		String javaType = getJavaType();
		if(javaType == null) return null;
		if(javaType.startsWith("java.lang.")) {
			int lastIndexOf = javaType.lastIndexOf(".");
			return lastIndexOf == -1 ? javaType : javaType.substring(lastIndexOf+1);
		}else {
			return javaType;
		}
	}
	
	public String getAsType() {
		return ActionScriptDataTypesUtils.getPreferredAsType(getJavaType());
	}
	
	public String getTestData() {
		return new TestDataGenerator().getDBUnitTestData(getColumnName(),getJavaType(),getSize());
	}

	public String getHtmlInputType() {
		return htmlInputType;
	}

	public void setHtmlInputType(String htmlInputType) {
		this.htmlInputType = htmlInputType;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public boolean isDictHasNull() {
		return dictHasNull;
	}

	public void setDictHasNull(boolean dictHasNull) {
		this.dictHasNull = dictHasNull;
	}

	public String getDictNullLable() {
		return dictNullLable;
	}

	public void setDictNullLable(String dictNullLable) {
		this.dictNullLable = dictNullLable;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}



	public String getJsValidateName() {
		return jsValidateName;
	}

	public void setJsValidateName(String jsValidateName) {
		this.jsValidateName = jsValidateName;
	}



	public String getDisplayFormat() {
		return displayFormat;
	}

	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat;
	}

	public String getParseFormat() {
		return parseFormat;
	}

	public void setParseFormat(String parseFormat) {
		this.parseFormat = parseFormat;
	}

	public String getQuerySqlOperator() {
		return querySqlOperator;
	}

	public void setQuerySqlOperator(String querySqlOperator) {
		this.querySqlOperator = querySqlOperator;
	}

	public String getQuerySqlLikeRule() {
		return querySqlLikeRule;
	}

	public void setQuerySqlLikeRule(String querySqlLikeRule) {
		this.querySqlLikeRule = querySqlLikeRule;
	}

	public String getColumnOrder() {
		return columnOrder;
	}

	public void setColumnOrder(String columnOrder) {
		this.columnOrder = columnOrder;
	}

	public String getColumncHtmlOrder() {
		return columncHtmlOrder;
	}

	public void setColumncHtmlOrder(String columncHtmlOrder) {
		this.columncHtmlOrder = columncHtmlOrder;
	}

	

	

	

	

	
}
