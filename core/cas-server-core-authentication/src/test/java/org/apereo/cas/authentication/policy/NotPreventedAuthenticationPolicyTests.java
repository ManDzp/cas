package org.apereo.cas.authentication.policy;

import org.apereo.cas.authentication.CoreAuthenticationTestUtils;
import org.apereo.cas.authentication.DefaultAuthenticationBuilder;
import org.apereo.cas.authentication.PreventedException;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is {@link NotPreventedAuthenticationPolicyTests}.
 *
 * @author Misagh Moayyed
 * @since 6.2.0
 */
public class NotPreventedAuthenticationPolicyTests {

    @Test
    public void verifyOperationPrevented() throws Exception {
        val input = new NotPreventedAuthenticationPolicy();
        val builder = new DefaultAuthenticationBuilder(CoreAuthenticationTestUtils.getPrincipal());
        val authn = builder.addFailure("Prevented", new PreventedException("error")).build();
        assertFalse(input.isSatisfiedBy(authn, Set.of()));
    }

    @Test
    public void verifyOperationNotPrevented() throws Exception {
        val input = new NotPreventedAuthenticationPolicy();
        val authn = new DefaultAuthenticationBuilder(CoreAuthenticationTestUtils.getPrincipal()).build();
        assertFalse(input.isSatisfiedBy(authn, Set.of()));
    }
}
