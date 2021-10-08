package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.TaskEntity;

public class TaskValidator {

    public static List<String> Validate(TaskEntity t){

        List<String> errors = new ArrayList<String>();
        String contentError = validateContent(t.getContent());

        if(!errors.equals("")) {
            errors.add(contentError);
        }

        return errors;
    }

    private static String validateContent(String content) {

        if(content == null || content.equals("")) {
            return "メッセージを入力してください。";
        }

        return "";
    }

}
