package com.droidev.util.expensetracker;

import com.droidev.util.expensetracker.utils.GeneralUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void getSecurePassword() throws Exception {
        assertEquals
                ("d66a3ef817838aaa436751623771a4c74581782a363e435efc3e59334e19922d3058439ef2a825719b7a78f2c8949114", GeneralUtils.getSecurePassword("8kihkijijk12*"));
    }
}