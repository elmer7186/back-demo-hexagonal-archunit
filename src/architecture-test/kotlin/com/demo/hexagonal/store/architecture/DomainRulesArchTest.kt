package com.demo.hexagonal.store.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.library.Architectures

@AnalyzeClasses(packages = ["com.demo.hexagonal.store.domain"])
class DomainRulesArchTest {

    @ArchTest
    fun `Files in service folder should ending with Service`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..service..").should()
                .haveSimpleNameEndingWith("Service").check(javaClasses)
    }

    @ArchTest
    fun `Files in port folder should ending with Port`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..port..").should()
                .haveSimpleNameEndingWith("Port").check(javaClasses)
    }

}