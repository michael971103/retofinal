package usa.mintic.com.example.retofinal.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.com.example.retofinal.Entities.Message;
import usa.mintic.com.example.retofinal.Repository.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return (List<Message>) messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if (e.isPresent()) {
                return message;
            } else {
                return messageRepository.save(message);
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> q = messageRepository.getMessage(message.getIdMessage());
            if(q.isPresent()){
                if (message.getMessageText() != null) {
                    q.get().setMessageText(message.getMessageText());
                }
                if (message.getBike() != null) {
                    q.get().setBike(message.getBike());
                }
                if (message.getClient() != null) {
                    q.get().setClient(message.getClient());
                }
                messageRepository.save(q.get());
                return q.get();
            } else {
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Message> p = messageRepository.getMessage(id);
        if(p.isPresent()){
            messageRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
