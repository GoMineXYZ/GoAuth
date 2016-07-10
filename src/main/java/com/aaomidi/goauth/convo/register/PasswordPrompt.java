package com.aaomidi.goauth.convo.register;

import com.aaomidi.goauth.GoAuth;
import com.aaomidi.goauth.convo.ConfirmationPrompt;
import com.aaomidi.goauth.utils.Lang;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.RegexPrompt;
import org.bukkit.entity.Player;
import xyz.mkotb.xenapi.ex.XenAPIException;
import xyz.mkotb.xenapi.req.RegisterRequest;

import java.util.regex.Pattern;

public class PasswordPrompt extends RegexPrompt {
    private final String email;

    public PasswordPrompt(String email) {
        super(Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"));
        this.email = email;
    }

    @Override
    protected String getFailedValidationText(ConversationContext context, String invalidInput) {
        return Lang.getInvalidInputMessage("password", invalidInput);
    }

    @Override
    public String getPromptText(ConversationContext conversationContext) {
        return Lang.getPasswordText();
    }

    @Override
    public Prompt acceptValidatedInput(ConversationContext conversationContext, String password) {
        return new ConfirmationPrompt(Lang.getConfirmMessage(password), (context, confirmed) -> {
            if (!confirmed) {
                return PasswordPrompt.this;
            }

            Player player = (Player) conversationContext.getForWhom();
            GoAuth plugin = GoAuth.getPlugin(GoAuth.class);

            try {
                plugin.getXenAPI().registerUser(new RegisterRequest(player.getName(), password, email));
                // waht do now TODO
            } catch (XenAPIException ex) {
                player.sendMessage(Lang.getRegisterErrorText(ex.id()));
            }

            return Prompt.END_OF_CONVERSATION;
        });
    }
}
