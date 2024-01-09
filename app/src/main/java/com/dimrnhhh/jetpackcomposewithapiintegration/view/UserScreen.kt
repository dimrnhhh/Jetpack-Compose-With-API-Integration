package com.dimrnhhh.jetpackcomposewithapiintegration.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dimrnhhh.jetpackcomposewithapiintegration.components.UserEmptyList
import com.dimrnhhh.jetpackcomposewithapiintegration.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel) {
    val users by viewModel.users.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    if (users.isEmpty()) {
        UserEmptyList()
    } else {
        LazyColumn {
            items(users) { user ->
                ListItem(
                    modifier = Modifier
                        .clickable { /* TODO */ },
                    headlineContent = { Text(text = user.name) },
                    supportingContent = { Text(text = user.email) },
                    trailingContent = { Text(text = "@" + user.username) },
                    leadingContent = {
                        Icon(
                            Icons.Rounded.AccountCircle, null
                        )
                    },
                )
                Divider(color = MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp))
            }
        }
    }
}