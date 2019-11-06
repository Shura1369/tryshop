package edu.voloshin.tryshop.models;


public class ConteinerId {
    private  TypeId typeId;
    private  String contId;

    public TypeId getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeId typeId) {
        this.typeId = typeId;
    }

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId;
    }

    private ConteinerId(){};
    private  static class ConteinerIdSingletonHolder{
        static ConteinerId instanse = new ConteinerId();
    }
    public static ConteinerId getConteinerId()
    {
        return ConteinerIdSingletonHolder.instanse;

    }
}
