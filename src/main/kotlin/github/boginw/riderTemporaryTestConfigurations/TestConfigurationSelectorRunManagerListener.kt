package github.boginw.riderTemporaryTestConfigurations

import com.intellij.execution.RunManager
import com.intellij.execution.RunManagerListener
import com.intellij.execution.RunnerAndConfigurationSettings
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.NonNls

class TestConfigurationSelectorRunManagerListener(
        private val project: Project,
) : RunManagerListener {

    companion object {
        private val LOG: @NonNls Logger = Logger.getInstance(TestConfigurationSelectorRunManagerListener::class.java)
    }

    override fun runConfigurationAdded(conf: RunnerAndConfigurationSettings) {
        if (conf.type.id != "RiderUnitTests") return

        LOG.info("Selecting new configuration")

        val runManager = RunManager.getInstance(project)
        runManager.selectedConfiguration = conf
    }
}
