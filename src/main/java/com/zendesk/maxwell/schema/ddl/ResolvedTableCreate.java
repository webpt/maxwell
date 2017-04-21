package com.zendesk.maxwell.schema.ddl;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.zendesk.maxwell.schema.*;
import com.zendesk.maxwell.MaxwellFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResolvedTableCreate extends ResolvedSchemaChange {
	static final Logger LOGGER = LoggerFactory.getLogger(ResolvedTableCreate.class);
	public String database;
	public String table;
	public Table def;


	public ResolvedTableCreate() {}
	public ResolvedTableCreate(Table t) {
		this.database = t.database;
		this.table = t.name;
		this.def = t;
	}

	@Override
	public void apply(Schema schema) throws InvalidSchemaError {
		Database d = schema.findDatabaseOrThrow(this.database);

		if ( d.hasTable(this.table) )
			LOGGER.warn("Unexpectedly asked to create existing table " + this.table);
		else {
			d.addTable(this.def);
		}
	}
}
