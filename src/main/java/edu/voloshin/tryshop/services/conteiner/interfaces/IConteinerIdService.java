package edu.voloshin.tryshop.services.conteiner.interfaces;


import edu.voloshin.tryshop.models.ConteinerId;
import edu.voloshin.tryshop.models.TypeId;

public interface IConteinerIdService {
    ConteinerId getContIdService();
    void setContIdService(TypeId typeId, String id);
    void clearContIdService();


}
