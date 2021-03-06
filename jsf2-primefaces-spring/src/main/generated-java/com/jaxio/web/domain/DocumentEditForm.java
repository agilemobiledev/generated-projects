/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring-conversation:src/main/java/domain/EditForm.e.vm.java
 */
package com.jaxio.web.domain;

import static com.jaxio.web.conversation.ConversationHolder.getCurrentConversation;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import com.jaxio.domain.Account;
import com.jaxio.domain.Document;
import com.jaxio.repository.DocumentRepository;
import com.jaxio.web.conversation.ConversationContext;
import com.jaxio.web.domain.AccountController;
import com.jaxio.web.domain.support.GenericEditForm;

/**
 * View Helper/Controller to edit {@link Document}.
 */
@Named
@Scope("conversation")
public class DocumentEditForm extends GenericEditForm<Document, String> {

    @Inject
    public void setDocumentRepository(DocumentRepository documentRepository) {
        setRepository(documentRepository);
    }

    public Document getDocument() {
        return getEntity();
    }

    // --------------------------------------------------
    // Support for auto-complete and callback many to one 
    // --------------------------------------------------

    public void setSelectedAccount(Account account) {
        // detach the currently set target if present
        //  1) to prevent any potential modification to go to the db
        //  2) to reduce session size        	
        if (getDocument().getAccount() != null) {
            getCurrentConversation().getEntityManager().detach(getDocument().getAccount());
        }

        if (account != null) {
            getDocument().setAccount(getCurrentConversation().getEntityManager().merge(account));
        } else {
            getDocument().setAccount(null);
        }
    }

    public Account getSelectedAccount() {
        return getDocument().getAccount();
    }

    // --------------------------------------------
    // Actions for account association
    // --------------------------------------------

    public String viewAccount() {
        ConversationContext<Account> ctx = AccountController.newEditContext(getDocument().getAccount());
        ctx.setLabelWithKey("document_account");
        getCurrentConversation().setNextContextSubReadOnly(ctx);
        return ctx.view();
    }
}