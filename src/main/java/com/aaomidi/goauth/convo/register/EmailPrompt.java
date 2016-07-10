package com.aaomidi.goauth.convo.register;

import com.aaomidi.goauth.convo.ConfirmationPrompt;
import com.aaomidi.goauth.utils.Lang;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.RegexPrompt;

import java.util.regex.Pattern;

public class EmailPrompt extends RegexPrompt {

    public EmailPrompt() {
        super(Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"));
    }

    @Override
    protected String getFailedValidationText(ConversationContext context, String invalidInput) {
        return Lang.getInvalidInputMessage("email", invalidInput);
    }

    @Override
    public String getPromptText(ConversationContext conversationContext) {
        return Lang.getRegisterEmailText();
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext conversationContext, String s) {
        return new ConfirmationPrompt(Lang.getConfirmMessage(s), (context, confirmed) -> confirmed ? new PasswordPrompt(s) : EmailPrompt.this);
    }
}
