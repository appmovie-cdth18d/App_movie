<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateDsDienViensTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ds_dienvien', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('dienvien_id')->unsigned()->index();
            $table->integer('phim_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('dienvien_id')->references('id')->on('dienvien');
            $table->foreign('phim_id')->references('id')->on('phim');

        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('ds_dienvien');
    }
}
