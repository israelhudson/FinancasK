package xyz.ihudapp.financask.extension

fun String.limitaEmAte(caracteres: Int) : String {
    if(this.length > 14){
        return "${this.substring(0, caracteres)}..."
    }

    return this
}