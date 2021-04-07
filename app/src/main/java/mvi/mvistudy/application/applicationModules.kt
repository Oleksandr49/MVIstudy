package mvi.mvistudy.application


import androidx.room.Room
import mvi.mvistudy.model.repository.DataObjectDatabase
import mvi.mvistudy.useCases.completabeUseCases.DataObjectDeleteUseCase
import mvi.mvistudy.useCases.completabeUseCases.DataObjectUpdateUseCase
import mvi.mvistudy.useCases.singleUseCases.DataObjectCreationSingleUseCase
import mvi.mvistudy.useCases.singleUseCases.DataObjectDetailsUseCase
import mvi.mvistudy.useCases.singleUseCases.DataObjectGetListUseCase
import mvi.mvistudy.viewModel.CreationFragmentViewModel
import mvi.mvistudy.viewModel.DetailsFragmentViewModel
import mvi.mvistudy.viewModel.EditionFragmentViewModel
import mvi.mvistudy.viewModel.ListFragmentViewModel
import mvi.mvistudy.model.repository.DataObjectRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvi.mvistudy.view.fragments.listFragment.ListFragmentIterator
import mvi.mvistudy.view.fragments.listFragment.adapter.ListFragmentAdapter
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModules = module {

    viewModel { CreationFragmentViewModel(get()) }
    viewModel { DetailsFragmentViewModel(get()) }
    viewModel { EditionFragmentViewModel(get(), get()) }
    viewModel { ListFragmentViewModel(get()) }

    single { ListFragmentIterator(get(), get())}
    single { DataObjectDeleteUseCase(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
    single { DataObjectCreationSingleUseCase(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
    single { DataObjectDetailsUseCase(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
    single { DataObjectGetListUseCase(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
    single { DataObjectUpdateUseCase(get(), Schedulers.io(), AndroidSchedulers.mainThread()) }
    single { DataObjectRepository(get()) }
    single { ListFragmentAdapter()}

    single {
        Room.databaseBuilder(androidApplication(),
            DataObjectDatabase::class.java, "DataObjectsDatabase"
        )
            .fallbackToDestructiveMigration()
            .build()
            .dataObjectDAO()
    }
}