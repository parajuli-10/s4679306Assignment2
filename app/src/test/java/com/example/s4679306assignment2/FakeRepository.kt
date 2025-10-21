package com.example.s4679306assignment2

import com.example.s4679306assignment2.data.Repository
import com.example.s4679306assignment2.data.remote.DashboardEntity
import com.example.s4679306assignment2.data.remote.DashboardResponse

class FakeRepository : Repository(
    api = throw IllegalStateException("Not used in fake")
) {
    private var shouldFailLogin = false
    private var shouldFailDash = false

    fun setFailLogin(v: Boolean) { shouldFailLogin = v }
    fun setFailDash(v: Boolean) { shouldFailDash = v }

    override suspend fun login(username: String, password: String): String {
        if (shouldFailLogin) error("bad creds")
        return "topicName"
    }

    override suspend fun dashboard(keypass: String): DashboardResponse {
        if (shouldFailDash) error("network")
        return DashboardResponse(
            entities = listOf(
                DashboardEntity("A", "B", "desc1"),
                DashboardEntity("C", "D", "desc2")
            ),
            entityTotal = 2
        )
    }
}
