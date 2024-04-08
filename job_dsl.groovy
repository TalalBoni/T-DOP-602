job('SEED') {
  displayName(params.DISPLAY_NAME)
  properties {
    githubProjectUrl("${params.GITHUB_NAME}")
    pipelineTriggers {
      scm('H/2 * * * *')
    }
  }
  steps {
    shell('make fclean')
    shell('make')
    shell('make tests_run')
    shell('make clean')
  }
}