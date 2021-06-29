package com.summerproposal

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class TestCoroutineRule : TestRule {


    override fun apply(base: Statement?, description: Description?): Statement {
        TODO("Not yet implemented")
    }
}