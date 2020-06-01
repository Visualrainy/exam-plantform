package exam.paperContext.common.mapper

import org.modelmapper.ModelMapper

class ModelMapperFactory {
    companion object {
        @JvmStatic
        val mapper = ModelMapper()
    }
}
