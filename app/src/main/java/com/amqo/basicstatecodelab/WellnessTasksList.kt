package com.amqo.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedChangeTask: (WellnessTask, Boolean) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedChangeTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}