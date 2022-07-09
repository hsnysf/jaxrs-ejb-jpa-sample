package employee.entity;

import java.sql.Timestamp;

import org.apache.johnzon.mapper.Converter;

public class TimestampConvertor implements Converter<Timestamp> {

	@Override
	public Timestamp fromString(String str) {
		
		return str != null ? Timestamp.valueOf(str) : null;
	}

	@Override
	public String toString(Timestamp timestamp) {

		return timestamp != null ? timestamp.toString() : null;
	}

}
