<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateLichChieusTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('lichchieu', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('phim_id')->unsigned()->index();
            $table->integer('rap_id')->unsigned()->index();
            $table->date('thgian_batdau');
            $table->date('thgian_ketthuc');
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('phim_id')->references('id')->on('phim');
            $table->foreign('rap_id')->references('id')->on('rap');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('lichchieu');
    }
}
