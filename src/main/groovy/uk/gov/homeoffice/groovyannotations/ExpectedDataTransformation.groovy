package uk.gov.homeoffice.groovyannotations

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation
import uk.gov.homeoffice.groovyannotations.data.IngestedDataProvider

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class ExpectedDataTransformation implements ASTTransformation {

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        def (annotation, annotatedMethod) = nodes
        println("" + annotation)
        if (annotation instanceof AnnotationNode) {
            def exp = annotation.members.get("expression").value
            def count = annotation.members.get("maxCount").value
            def bs = createStatements(exp, count, annotatedMethod
                    .parameters[0].name)
            def methodStatements = annotatedMethod.code.statements
            methodStatements.add(0, bs)
        }
    }

    BlockStatement createStatements(String exp, int count, String
            variableName) {
        def statements = "uk.gov.homeoffice.groovyannotations.data.IngestedDataProvider.getData('"+ exp +"'," + variableName+" )"
        AstBuilder ab = new AstBuilder()
        List<ASTNode> res = ab.buildFromString(CompilePhase
                .SEMANTIC_ANALYSIS, statements)
        return res[0]
    }

}
