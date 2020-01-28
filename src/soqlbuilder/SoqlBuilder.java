package soqlbuilder;


import enums.OrderByNulls;
import enums.OrderBySorting;

public class SoqlBuilder {

    private String soql = "";

    private String fields = "";
    private String sObject = "";
    private String whereClause = "";
    private String groupBy = "";
    private String orderByFields = "";
    private String orderBySorting = "";
    private String orderByNulls = "";
    private String limit = "";
    private String offset = "";


    public SoqlBuilder select(FieldsList fields) {
        if (this.fields.length() == 0) {
            this.fields = fields.getResultingList();
        } else {
            this.fields = this.fields + ", " + fields.getResultingList();
        }
        return this;
    }

    public SoqlBuilder from(String sObject) {
        this.sObject = sObject;
        return this;
    }

    public SoqlBuilder orderBy(FieldsList fields) {
        this.orderByFields = fields.getResultingList();
        this.orderBySorting = "";
        this.orderByNulls = "";
        return this;
    }

    public SoqlBuilder orderBy(FieldsList fields, OrderBySorting sortingOrder) {
        this.orderByFields = fields.getResultingList();
        switch (sortingOrder) {
            case ASC:
                this.orderBySorting = "ASC";
                break;
            case DESC:
                this.orderBySorting = "DESC";
                break;
        }
        this.orderByNulls = "";
        return this;
    }

    public SoqlBuilder orderBy(FieldsList fields, OrderByNulls orderByNulls) {
        this.orderByFields = fields.getResultingList();
        switch (orderByNulls) {
            case NULLS_FIRST:
                this.orderByNulls = "NULLS FIRST";
                break;
            case NULLS_LAST:
                this.orderByNulls = "NULLS LAST";
                break;
        }
        this.orderBySorting = "";
        return this;
    }

    public SoqlBuilder orderBy(FieldsList fields, OrderBySorting sortingOrder, OrderByNulls orderByNulls) {
        this.orderByFields = fields.getResultingList();
        switch (orderByNulls) {
            case NULLS_FIRST:
                this.orderByNulls = "NULLS FIRST";
                break;
            case NULLS_LAST:
                this.orderByNulls = "NULLS LAST";
                break;
        }
        switch (sortingOrder) {
            case ASC:
                this.orderBySorting = "ASC";
                break;
            case DESC:
                this.orderBySorting = "DESC";
                break;
        }
        return this;
    }

    public SoqlBuilder limit(String limit) {
        this.limit = limit;
        return this;
    }

    public SoqlBuilder offset(String offset) {
        this.offset = offset;
        return this;
    }

    public String buildSoql() {
        soql = "SELECT ";
        soql = soql + fields + " ";
        soql = soql + "FROM ";
        soql = soql + sObject + " ";

        if (whereClause.length() != 0) {
            soql = soql + whereClause + " ";
        }

        if (orderByFields.length() != 0) {
            soql = soql + "ORDER BY " + orderByFields + " ";
            if (orderBySorting.length() != 0) {
                soql = soql + orderBySorting + " ";
            }
            if (orderByNulls.length() != 0) {
                soql = soql + orderByNulls + " ";
            }
        }

        if (limit.length() != 0) {
            soql = soql + "LIMIT " + limit + " ";
        }

        if (offset.length() != 0) {
            soql = soql + "OFFSET " + offset + " ";
        }

        return soql;
    }
}

