# Sometimes it's a README fix, or something like that - which isn't relevant for
# including in a project's CHANGELOG for example
declared_trivial = github.pr_title.include? "#trivial"

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("Work in Progress") if github.pr_title.include? "WIP"

# Warn when there is a big PR
warn("Big PR > 1000") if git.lines_of_code > 1000

# Reviewers
has_assignee = github.pr_json["assignee"] != nil
warn("No Assign", sticky: false) unless has_assignee

# Testing
# @TODO I'll think this later.
# is_source_changed = !git.modified_files.grep(/^main\/kotlin/).empty?
# is_test_changed = !git.modified_files.grep(/^test\/kotlin/).empty?
#if is_source_changed && !is_test_changed
#  warn('Must update to tests')
#end

# Android Lint
android_lint.gradle_task = "app:lintDevelopRelease"
android_lint.report_file = "app/build/reports/lint-results-developRelease.xml"
android_lint.filtering = true
android_lint.lint(inline_mode: true)

# Findbugs
findbugs.gradle_module = "app"
findbugs.gradle_task = "app:findbugs"
findbugs.report_file = "app/build/reports/findbugs/findbugs.xml"
findbugs.report

# checkstyle
github.dismiss_out_of_range_messages
checkstyle_format.base_path = Dir.pwd
checkstyle_format.report "app/build/reports/ktlint/ktlint-checkstyle-report.xml"
