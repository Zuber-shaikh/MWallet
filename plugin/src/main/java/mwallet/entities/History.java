package mwallet.entities;

public class History extends BaseEntity{
    private String history;

    public History(String history) {
        this.history = history;
    }

    public History(String id, String history) {
        this.id = id;
        this.history = history;
    }

    public String getId(){
        return id;
    }

    public String getHistory(){
        return history;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        History other = (History) obj;
        if(id == null) {
            if(other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        return true;

    }

    @Override
    public String toString() {
        return "TransactionId : " + id +" " + history;
    }
}
