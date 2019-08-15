/*
 * This file is generated by jOOQ.
 */
package ru.eltex.database.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;

import ru.eltex.database.DefaultSchema;
import ru.eltex.database.tables.records.ManAndSaleRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ManAndSale extends TableImpl<ManAndSaleRecord> {

    private static final long serialVersionUID = 1100338486;

    /**
     * The reference instance of <code>Man_and_Sale</code>
     */
    public static final ManAndSale MAN_AND_SALE = new ManAndSale();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ManAndSaleRecord> getRecordType() {
        return ManAndSaleRecord.class;
    }

    /**
     * The column <code>Man_and_Sale.id_man</code>.
     */
    public final TableField<ManAndSaleRecord, Integer> ID_MAN = createField("id_man", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>Man_and_Sale.id_sale</code>.
     */
    public final TableField<ManAndSaleRecord, Integer> ID_SALE = createField("id_sale", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>Man_and_Sale</code> table reference
     */
    public ManAndSale() {
        this(DSL.name("Man_and_Sale"), null);
    }

    /**
     * Create an aliased <code>Man_and_Sale</code> table reference
     */
    public ManAndSale(String alias) {
        this(DSL.name(alias), MAN_AND_SALE);
    }

    /**
     * Create an aliased <code>Man_and_Sale</code> table reference
     */
    public ManAndSale(Name alias) {
        this(alias, MAN_AND_SALE);
    }

    private ManAndSale(Name alias, Table<ManAndSaleRecord> aliased) {
        this(alias, aliased, null);
    }

    private ManAndSale(Name alias, Table<ManAndSaleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ManAndSaleRecord> getPrimaryKey() {
        return Internal.createUniqueKey(ru.eltex.database.tables.ManAndSale.MAN_AND_SALE, "KEY_Man_and_Sale_PRIMARY", ru.eltex.database.tables.ManAndSale.MAN_AND_SALE.ID_MAN, ru.eltex.database.tables.ManAndSale.MAN_AND_SALE.ID_SALE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ManAndSaleRecord>> getKeys() {
        return Arrays.<UniqueKey<ManAndSaleRecord>>asList(
              Internal.createUniqueKey(ru.eltex.database.tables.ManAndSale.MAN_AND_SALE, "KEY_Man_and_Sale_PRIMARY", ru.eltex.database.tables.ManAndSale.MAN_AND_SALE.ID_MAN, ru.eltex.database.tables.ManAndSale.MAN_AND_SALE.ID_SALE)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ManAndSale as(String alias) {
        return new ManAndSale(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ManAndSale as(Name alias) {
        return new ManAndSale(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ManAndSale rename(String name) {
        return new ManAndSale(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ManAndSale rename(Name name) {
        return new ManAndSale(name, null);
    }
}
