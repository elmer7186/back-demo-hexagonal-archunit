package com.demo.hexagonal.store.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["src.main.kotlin.com.demo.hexagonal.store.application"])
class ApplicationRulesArchTest {

    @ArchTest
    fun `Files in application service folder should ending with AppService`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..application.service..")
                .should().haveSimpleNameEndingWith("AppService").check(javaClasses)
    }

    @ArchTest
    fun `Files in application mapper folder should ending with AppMapper`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..application.mapper..")
                .should().haveSimpleNameEndingWith("AppMapper").check(javaClasses)
    }

    @ArchTest
    fun `Files in DTO folder should ending with Dto`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..dto..")
                .should().haveSimpleNameEndingWith("Dto").check(javaClasses)
    }

}