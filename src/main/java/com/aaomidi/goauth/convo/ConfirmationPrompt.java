package com.aaomidi.goauth.convo;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.ValidatingPrompt;

public class ConfirmationPrompt extends ValidatingPrompt {
    private String promptText;
    private ConfirmationPromptCallback callback;

    public ConfirmationPrompt(String promptText, ConfirmationPromptCallback callback) {
        this.promptText = promptText;
        this.callback = callback;
    }

    @Override
    protected boolean isInputValid(ConversationContext conversationContext, String s) {
        return s.toLowerCase().startsWith("y") || s.toLowerCase().startsWith("n");
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext conversationContext, String s) {
        return callback.callback(conversationContext, s.toLowerCase().startsWith("y"));
    }

    @Override
    public String getPromptText(ConversationContext conversationContext) {
        return promptText;
    }
}
