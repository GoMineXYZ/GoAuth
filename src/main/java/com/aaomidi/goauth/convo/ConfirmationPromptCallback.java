package com.aaomidi.goauth.convo;

import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;

public interface ConfirmationPromptCallback {
    Prompt callback(ConversationContext context, boolean confirmed);
}
