package edu.voloshin.tryshop.services.conteiner.impl;


import edu.voloshin.tryshop.models.ConteinerId;
import edu.voloshin.tryshop.models.TypeId;
import edu.voloshin.tryshop.services.conteiner.interfaces.IConteinerIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ConteinerIdServiceImpl implements IConteinerIdService {

    ConteinerId conteinerId = ConteinerId.getConteinerId();


    @Override
    public ConteinerId getContIdService() {
        return conteinerId;
    }

    @Override
    public void setContIdService(TypeId typeId, String id) {
        conteinerId.setTypeId(typeId);
        conteinerId.setContId(id);
    }

    @Override
    public void clearContIdService() {
        conteinerId.setContId(null);
        conteinerId.setContId(null);
    }




}
