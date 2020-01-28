package soqlbuilder;

import java.util.List;

public class FieldsList {

    private String resultingList = "";

    public FieldsList add(String fields) {
        if(this.resultingList.length() == 0) {
            this.resultingList = fields;
            return this;
        } else {
            this.resultingList = this.resultingList + ", " + fields;
            return this;
        }
    }

    public FieldsList add(List<String> fields) {
        if(this.resultingList.length() == 0) {
            this.resultingList = String.join(", ", fields);
            return this;
        } else {
            this.resultingList = this.resultingList + ", " + String.join(", ", fields);
            return this;
        }
    }

    public String getResultingList() {
        return resultingList;
    }
}

