package io.andygrove.ballista.jdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.List;

import org.apache.arrow.vector.FieldVector;

/** ResultSetMetaData. */
public class FlightResultSetMetaData implements ResultSetMetaData {

  private final List<FieldVector> fields;

  public FlightResultSetMetaData(final List<FieldVector> fields) {
    this.fields = fields;
  }

  @Override
  public int getColumnCount() throws SQLException {
    return fields.size();
  }

  @Override
  public boolean isAutoIncrement(int i) throws SQLException {
    return false;
  }

  @Override
  public boolean isCaseSensitive(int i) throws SQLException {
    return false;
  }

  @Override
  public boolean isSearchable(int i) throws SQLException {
    return false;
  }

  @Override
  public boolean isCurrency(int i) throws SQLException {
    return false;
  }

  @Override
  public int isNullable(int i) throws SQLException {
    return ResultSetMetaData.columnNullable;
  }

  @Override
  public boolean isSigned(int i) throws SQLException {
    return true;
  }

  @Override
  public int getColumnDisplaySize(int i) throws SQLException {
    return 0;
  }

  @Override
  public String getColumnLabel(int i) throws SQLException {
    return null;
  }

  @Override
  public String getColumnName(int i) throws SQLException {
    return fields.get(i - 1).getName();
  }

  @Override
  public String getSchemaName(int i) throws SQLException {
    return null;
  }

  @Override
  public int getPrecision(int i) throws SQLException {
    throw new SQLFeatureNotSupportedException();
  }

  @Override
  public int getScale(int i) throws SQLException {
    throw new SQLFeatureNotSupportedException();
  }

  @Override
  public String getTableName(int i) throws SQLException {
    return null;
  }

  @Override
  public String getCatalogName(int i) throws SQLException {
    return null;
  }

  @Override
  public int getColumnType(int i) throws SQLException {
    switch (fields.get(i - 1).getMinorType()) {
      case INT:
        return Types.INTEGER;
      default:
        return Types.OTHER;
    }
  }

  @Override
  public String getColumnTypeName(int i) throws SQLException {
    return String.valueOf(fields.get(i - 1).getMinorType());
  }

  @Override
  public boolean isReadOnly(int i) throws SQLException {
    return false;
  }

  @Override
  public boolean isWritable(int i) throws SQLException {
    return false;
  }

  @Override
  public boolean isDefinitelyWritable(int i) throws SQLException {
    return false;
  }

  @Override
  public String getColumnClassName(int i) throws SQLException {
    throw new SQLFeatureNotSupportedException();
  }

  @Override
  public <T> T unwrap(Class<T> aClass) throws SQLException {
    throw new SQLFeatureNotSupportedException();
  }

  @Override
  public boolean isWrapperFor(Class<?> aClass) throws SQLException {
    throw new SQLFeatureNotSupportedException();
  }
}
