package org.example.schoology.runner;

import java.util.Arrays;
import java.util.Locale;

import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;

import org.example.schoology.pages.courses.CourseForm;
import org.example.schoology.pages.groups.GroupForm;

public class TypeRegistries implements TypeRegistryConfigurer {

    /**
     * {@inheritDoc}
     */
    public Locale locale() {
        return Locale.ENGLISH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configureTypeRegistry(final io.cucumber.core.api.TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(CourseForm.class,
                (TableCellTransformer<CourseForm>) cell -> Arrays.stream(CourseForm.values())
                        .filter(e -> e.getName().equalsIgnoreCase(cell)).findFirst().get()));
        typeRegistry.defineDataTableType(new DataTableType(GroupForm.class,
                (TableCellTransformer<GroupForm>) cell -> Arrays.stream(GroupForm.values())
                        .filter(e -> e.getName().equalsIgnoreCase(cell)).findFirst().get()));
    }
}
