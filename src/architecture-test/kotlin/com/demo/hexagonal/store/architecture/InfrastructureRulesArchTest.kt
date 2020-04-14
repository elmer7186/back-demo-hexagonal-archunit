package com.demo.hexagonal.store.architecture

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["com.demo.hexagonal.store.infrastructure"])
class InfrastructureRulesArchTest {

    @ArchTest
    fun `Files in controller folder should ending with Controller`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..controller..")
                .should().haveSimpleNameEndingWith("Controller").check(javaClasses)
    }

    @ArchTest
    fun `Files in config folder should ending with config`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..config..")
                .should().haveSimpleNameEndingWith("Config").check(javaClasses)
    }

    @ArchTest
    fun `Files in adapter repository folder should ending with RepositoryAdapter`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..adapter.repository")
                .should().haveSimpleNameEndingWith("RepositoryAdapter").check(javaClasses)
    }

    @ArchTest
    fun `Files in entity repository folder should ending with Entity`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..entity..")
                .should().haveSimpleNameEndingWith("Entity").check(javaClasses)
    }

    @ArchTest
    fun `Files in mapper adapter folder should ending with Mapper`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..mapper..")
                .should().haveSimpleNameEndingWith("Mapper").check(javaClasses)
    }

    @ArchTest
    fun `Files in jpa repository folder should ending with JpaRepository`(javaClasses: JavaClasses) {
        classes().that().resideInAPackage("..repository.jpa..")
                .should().haveSimpleNameEndingWith("JpaRepository").check(javaClasses)
    }

}